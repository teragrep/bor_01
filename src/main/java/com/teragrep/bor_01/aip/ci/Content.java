package com.teragrep.bor_01.aip.ci;

import com.teragrep.bor_01.NamespacedJsonable;

public interface Content extends NamespacedJsonable {
    Representation representation();
    DataObject dataObject();
}
