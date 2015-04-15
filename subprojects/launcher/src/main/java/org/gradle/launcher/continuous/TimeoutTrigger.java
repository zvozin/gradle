/*
 * Copyright 2015 the original author or authors.
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

package org.gradle.launcher.continuous;

import org.gradle.internal.UncheckedException;

public class TimeoutTrigger implements Runnable {
    private final TriggerListener listener;

    public TimeoutTrigger(TriggerListener listener) {
        this.listener = listener;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(5000);
                listener.triggered(new DefaultTriggerDetails("5 second timeout"));
            } catch (InterruptedException e) {
                UncheckedException.throwAsUncheckedException(e);
            }
        }
    }
}
