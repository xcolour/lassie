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
package com.bazaarvoice.lassie.screenboard.widgets;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * The ConditionalFormat class is mainly used in the {@link QueryValue} class.
 * It holds The Color that the {@link Widget} will be once the conditions met by the aggregated value,
 * the comparator, and the threshold value.
 */
public class ConditionalFormat {
    @JsonProperty("color")
    private Color _color = Color.WHITE_ON_GREEN;
    @JsonProperty("invert")
    private boolean _inverted = false;
    @JsonProperty("comparator")
    private Comparator _comparator = Comparator.GREATER;
    @JsonProperty("value")
    private double _value = 0;

    /**
     * Conditional format constructor that sets the  {@link Color} based on the  aggregated value versus
     * the value using the comparator.
     *
     * @param color      Color of the conditional format.
     * @param inverted   Compares the aggregated value to the threshold value.
     * @param comparator The Comparator used in the comparison between the aggregated value and the (threshold) value.
     * @param value      The threshold value compared to the aggregated value.
     */
    public ConditionalFormat(Color color, boolean inverted, Comparator comparator, double value) {
        _color = checkNotNull(color, "color is null");
        _inverted = inverted;
        _comparator = checkNotNull(comparator, "comparator is null");
        _value = checkNotNull(value, "value is null");
    }

    /** Private constructor used for deserialization. */
    private ConditionalFormat() {
    }

    @JsonIgnore
    public Color getColor() {
        return _color;
    }

    public void setColor(Color color) {
        _color = checkNotNull(color, "color is null");
    }

    @JsonIgnore
    public boolean isInverted() {
        return _inverted;
    }

    public void setInverted(boolean inverted) {
        _inverted = inverted;
    }

    @JsonIgnore
    public Comparator getComparator() {
        return _comparator;
    }

    public void setComparator(Comparator comparator) {
        _comparator = checkNotNull(comparator, "comparator is null");
    }

    @JsonIgnore
    public double getValue() {
        return _value;
    }

    public void setValue(double value) {
        _value = value;
    }

    public String toString() {
        return "ConditionalFormat[" +
                "color=" + getColor() +
                ", inverted=" + isInverted() +
                ", comparator=" + getComparator() +
                ", value=" + getValue() +
                "]";
    }
}
