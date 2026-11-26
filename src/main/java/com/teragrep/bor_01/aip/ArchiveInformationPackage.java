package com.teragrep.bor_01.aip;

import com.teragrep.bor_01.Namespaceable;
import com.teragrep.bor_01.NamespacedJsonable;
import com.teragrep.bor_01.aip.ci.Content;
import com.teragrep.bor_01.aip.pdi.PreservationDescription;

public interface ArchiveInformationPackage extends NamespacedJsonable, Namespaceable {
    Content content();
    PreservationDescription preservationDescription();
}