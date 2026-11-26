package com.teragrep.bor_01.aip.pdi;

import com.teragrep.bor_01.NamespacedJsonable;

public interface PreservationDescription extends NamespacedJsonable {
    Reference reference();
    Provenance provenance();
    Context context();
    Fixity fixity();
    AccessRights accessRights();
}
