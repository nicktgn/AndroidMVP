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

package org.nicktgn.mvp_sample.ui;

import android.os.Bundle;

import org.nicktgn.mvp.MvpActivity;
import org.nicktgn.mvp_sample.R;
import org.nicktgn.mvp_sample.presensters.MemoryCalculatorPresenter;

public class MemoryCalculatorActivity extends MvpActivity<MemoryCalculatorPresenter.MemoryCalculatorView, MemoryCalculatorPresenter>
									implements MemoryCalculatorPresenter.MemoryCalculatorView {



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	protected MemoryCalculatorPresenter createPresenter() {
		return new MemoryCalculatorPresenter();
	}
}
