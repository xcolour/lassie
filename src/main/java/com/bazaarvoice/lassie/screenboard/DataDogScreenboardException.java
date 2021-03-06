/*
 * Copyright 2013 Bazaarvoice, Inc.
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
package com.bazaarvoice.lassie.screenboard;

import com.google.common.base.Joiner;

import java.util.List;

/** This class is an exception wrapper class. */
public class DataDogScreenboardException extends Exception {
    public DataDogScreenboardException() {
    }

    public DataDogScreenboardException(String message) {
        super(message);
    }

    public DataDogScreenboardException(List<String> errors) {
        super(Joiner.on('\n').join(errors));
    }

    public DataDogScreenboardException(List<String> errors, Exception cause) {
        super(Joiner.on('\n').join(errors), cause);
    }
}