// This file is part of the secs4j project, an open source SECS/GEM
// library written in Java.
//
// Copyright 2013 Oscar Stigter
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package org.ozsoft.secs4j.format;

import org.junit.Assert;
import org.junit.Test;
import org.ozsoft.secs4j.format.I1;

public class I1Test {
    
    @Test
    public void test() {
        I1 i1 = new I1();
        Assert.assertEquals(0, i1.length());
        Assert.assertEquals("<I1>", i1.toSml());

        i1.addValue(0);
        i1.addValue(1);
        i1.addValue(-1);
        i1.addValue(127);
        i1.addValue(-128);
        Assert.assertEquals(5, i1.length());
        Assert.assertEquals("<I1 0 1 -1 127 -128>", i1.toSml());
        TestUtils.assertEquals(new byte[] {0x65, 0x05, 0x00, 0x01, (byte) 0xff, 0x7f, (byte) 0x80}, i1.toByteArray());
    }
    
}
