package com.teragrep.bor_01.aip.ci;

import com.teragrep.bor_01.NamespacedJsonable;

public interface DataObject extends NamespacedJsonable {
    String path();
    String container();
    String storageURI(); // not yet in db

}
