//  Copyright 2020 VMware, Inc.
//  SPDX-License-Identifier: MIT
//

package org.c19x.sensor.ble;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanResult;

import org.c19x.sensor.datatype.PayloadData;
import org.c19x.sensor.datatype.PayloadSharingData;
import org.c19x.sensor.datatype.TargetIdentifier;

import java.util.List;

/// Registry for collating fragments of information from asynchronous BLE operations.
public interface BLEDatabase {
    /// Add delegate for handling database events
    void add(BLEDatabaseDelegate delegate);

    /// Get or create device for collating information from asynchronous BLE operations.
    BLEDevice device(ScanResult scanResult);

    /// Get or create device for collating information from asynchronous BLE operations.
    BLEDevice device(BluetoothDevice bluetoothDevice);

    /// Get or create device for collating information from asynchronous BLE operations.
    BLEDevice device(PayloadData payloadData);

    /// Get all devices
    List<BLEDevice> devices();

    /// Delete
    void delete(TargetIdentifier identifier);

    /// Get payload sharing data for a peer
    PayloadSharingData payloadSharingData(BLEDevice peer);
}
