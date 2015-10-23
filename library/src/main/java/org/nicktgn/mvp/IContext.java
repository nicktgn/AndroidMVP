/*
 * Copyright 2015 Nick Tsygankov (nicktgn@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.nicktgn.mvp;

import android.os.Bundle;

/**
 * Abstract interface for Android context
 * Used for mocking, instead of having dependency on Android's MockContext
 * @author nicktgn
 */
public interface IContext {

	/**
	 * Launch a new activity
	 * @param dest  intent
	 * @param data  options
	 */
	void startActivity(Class<?> dest, Bundle data);

}
