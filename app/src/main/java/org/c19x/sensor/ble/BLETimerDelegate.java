//  Copyright 2020 VMware, Inc.
//  SPDX-License-Identifier: MIT
//

package org.c19x.sensor.ble;

public interface BLETimerDelegate {

    void bleTimer(long currentTimeMillis);
}
