//  Copyright 2020 VMware, Inc.
//  SPDX-License-Identifier: MIT
//

package org.c19x.sensor.payload.c19x;

import org.c19x.sensor.datatype.PayloadData;
import org.c19x.sensor.datatype.PayloadTimestamp;
import org.c19x.sensor.payload.DefaultPayloadDataSupplier;
import org.c19x.sensor.payload.PayloadDataSupplier;

/// C19X payload supplier for integration with C19X decentralised contact tracing solution.
public class C19XPayloadDataSupplier extends DefaultPayloadDataSupplier {
    private final DayCodes dayCodes;
    private final BeaconCodes beaconCodes;
    private final PayloadData emptyPayloadData = new PayloadData();

    public C19XPayloadDataSupplier(final SharedSecret sharedSecret) {
        dayCodes = new ConcreteDayCodes(sharedSecret);
        beaconCodes = new ConcreteBeaconCodes(dayCodes);
    }

    @Override
    public PayloadData payload(PayloadTimestamp timestamp) {
        final BeaconCode beaconCode = beaconCodes.get(new Timestamp(timestamp.value));
        if (beaconCode == null) {
            return emptyPayloadData;
        }
        return new PayloadData(JavaData.longToByteArray(beaconCode.value));
    }
}
