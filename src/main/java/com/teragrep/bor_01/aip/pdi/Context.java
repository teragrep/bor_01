package com.teragrep.bor_01.aip.pdi;

import com.teragrep.bor_01.NamespacedJsonable;

public interface Context extends NamespacedJsonable {
    String logtag();
    String hostname();
    String organization();
}
