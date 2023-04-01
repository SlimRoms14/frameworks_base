/*
 * Copyright (C) 2007 The Android Open Source Project
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

package com.android.providers.settings;

import android.util.ArraySet;

import java.util.Arrays;
import java.util.Set;

/**
 * Contains the list of prefixes for namespaces in which any flag can be written with adb.
 * <p>
 * A security review is required for any prefix that's added to this list. To add to
 * the list, create a change and tag the OWNER. In the change description, include a
 * description of the flag's functionality, and a justification for why it needs to be
 * allowlisted.
 */
final class WritableNamespacePrefixes {
    public static final Set<String> ALLOWLIST =
            new ArraySet<String>(Arrays.asList(
                "app_compat_overrides",
                "game_overlay",
                "namespace1"
            ));
}
