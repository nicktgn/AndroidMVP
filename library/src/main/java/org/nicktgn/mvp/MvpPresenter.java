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
 * Basic Presenter interface
 * @author nicktgn
 */
public interface MvpPresenter<V extends MvpView> {

	/**
	 * Get the Bundle with Model data operated by Presenter.
	 * This Bundle can be used to save/restore Model data between destruction and re-creation of
	 * the Views. <br/>
	 * See README or source of {@link MvpAppCompatActivity} and {@link MvpFragment} for
	 * an example of how to save/restore Presenter state. <br/>
	 * Common places to use this:<br/>
	 * <ul>
	 *    <li>In Activities:
	 *    	<ul>
	 *    		<li>{@link android.app.Activity#onSaveInstanceState(Bundle)}</li>
	 *    	</ul>
	 *    </li>
	 *    <li>In Fragments:
	 *    	<ul>
	 *    	 	<li>{@link android.app.Fragment#onDestroyView()} when only Fragment's view is
	 *    	 	destroyed/re-created; use helper class {@link MvpState} to save the state in this case</li>
	 *    		<li>{@link android.app.Fragment#onSaveInstanceState(Bundle)} when the Activity
	 *    		containing the fragment also gets destroyed/re-created</li>
	 *    	</ul>
	 *    </li>
	 * </ul
	 * @return Bundle with Model data
	 */
	Bundle getModelData();

	/**
	 * Usually is called after the View has been created and it is ready to be attached to Presenter
	 * to be populated with Model data.<br/>
	 * In this method Presenter decides how to present Model data through View's interface.
	 * Common places to invoke this:<br/>
	 * <ul>
	 *    <li>{@link android.app.Activity#onStart()}; make sure to call
	 *    {@link MvpPresenter#isViewAttached()} first to check that it has not been attached yet.</li>
	 *    <li>{@link android.app.Fragment#onActivityCreated(Bundle)}; make sure to call
	 *    {@link MvpPresenter#isViewAttached()} first to check that it has not been attached yet.</li>
	 * </ul>
	 * @param view View related to this Presenter
	 * @param cachedData saved state of the Model data used by this Presenter, if any
	 * @param context abstract Context interface
	 */
	void attachView(V view, Bundle cachedData, IContext context);

	/**
	 * Usually is called before the View is going to be destroyed.<br/>
	 * Common places to invoke this:<br/>
	 * <ul>
	 *    <li>{@link android.app.Activity#onStart()}; make sure to call
	 *    {@link MvpPresenter#isViewAttached()} first to check that it has not been attached yet.</li>
	 *    <li>{@link android.app.Fragment#onActivityCreated(Bundle)}; make sure to call
	 *    {@link MvpPresenter#isViewAttached()} first to check that it has not been attached yet.</li>
	 * </ul>
	 * @param retainInstance indicates whether the View instance will be retained: can be useful in
	 *                       case of Fragments ({@link android.app.Fragment#setRetainInstance(boolean)})
	 */
	void detachView(boolean retainInstance);

	/**
	 * Checks if the View is already attached to this Presenter
	 * @return true if View is attached, false otherwise
	 */
	boolean isViewAttached();
}
