//  Copyright 2021 Herald Project Contributors
//  SPDX-License-Identifier: Apache-2.0
//

package com.vmware.herald.sensor.analysis.sampling;

import com.vmware.herald.sensor.datatype.Date;
import com.vmware.herald.sensor.datatype.DoubleValue;

public interface AnalysisProvider<T extends DoubleValue, U extends DoubleValue> {

    Class<T> inputType();

    Class<U> outputType();

    boolean analyse(final Date timeNow, final SampledID sampled, final SampleList<T> input, final SampleList<U> output, final CallableForNewSample<U> callable);
}
