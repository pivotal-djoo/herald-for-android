//  Copyright 2021 Herald Project Contributors
//  SPDX-License-Identifier: Apache-2.0
//

package io.heraldprox.herald.sensor.datatype;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

/// UTC date time
public class Date extends java.util.Date {
    private final static SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.UK);
    static {
        dateFormatter.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    public Date() {
        super();
    }

    public Date(final java.util.Date date) {
        super(date.getTime());
    }

    public Date(final long secondsSinceUnixEpoch) {
        super(secondsSinceUnixEpoch * 1000);
    }

    public long secondsSinceUnixEpoch() {
        return getTime() / 1000;
    }

    public String toString() {
        return dateFormatter.format(this);
    }
}
