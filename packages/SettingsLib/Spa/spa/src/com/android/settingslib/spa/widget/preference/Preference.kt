/*
 * Copyright (C) 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.settingslib.spa.widget.preference

import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import com.android.settingslib.spa.framework.common.EntryMarco
import com.android.settingslib.spa.framework.common.EntrySearchData
import com.android.settingslib.spa.framework.compose.navigator
import com.android.settingslib.spa.framework.compose.stateOf
import com.android.settingslib.spa.widget.ui.createSettingsIcon

data class SimplePreferenceMarco(
    val title: String,
    val summary: String? = null,
    val icon: ImageVector? = null,
    val disabled: Boolean = false,
    val clickRoute: String? = null,
    val searchKeywords: List<String> = emptyList(),
) : EntryMarco {
    @Composable
    override fun UiLayout() {
        Preference(model = object : PreferenceModel {
            override val title: String = this@SimplePreferenceMarco.title
            override val summary = stateOf(this@SimplePreferenceMarco.summary ?: "")
            override val icon = createSettingsIcon(this@SimplePreferenceMarco.icon)
            override val enabled = stateOf(!this@SimplePreferenceMarco.disabled)
            override val onClick = navigator(clickRoute)
        })
    }

    override fun getSearchData(): EntrySearchData {
        return EntrySearchData(
            title = this@SimplePreferenceMarco.title,
            keyword = searchKeywords
        )
    }
}

/**
 * The widget model for [Preference] widget.
 */
interface PreferenceModel {
    /**
     * The title of this [Preference].
     */
    val title: String

    /**
     * The summary of this [Preference].
     */
    val summary: State<String>
        get() = stateOf("")

    /**
     * The icon of this [Preference].
     *
     * Default is `null` which means no icon.
     */
    val icon: (@Composable () -> Unit)?
        get() = null

    /**
     * Indicates whether this [Preference] is enabled.
     *
     * Disabled [Preference] will be displayed in disabled style.
     */
    val enabled: State<Boolean>
        get() = stateOf(true)

    /**
     * The on click handler of this [Preference].
     *
     * This also indicates whether this [Preference] is clickable.
     */
    val onClick: (() -> Unit)?
        get() = null
}

/**
 * Preference widget.
 *
 * Data is provided through [PreferenceModel].
 */
@Composable
fun Preference(model: PreferenceModel) {
    val modifier = remember(model.enabled.value, model.onClick) {
        model.onClick?.let { onClick ->
            Modifier.clickable(enabled = model.enabled.value, onClick = onClick)
        } ?: Modifier
    }
    BasePreference(
        title = model.title,
        summary = model.summary,
        modifier = modifier,
        icon = model.icon,
        enabled = model.enabled,
    )
}
