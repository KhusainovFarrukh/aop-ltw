@FilterDef(
    name = "tenantFilter",
    defaultCondition = "tenant = :tenant",
    parameters = @ParamDef(name = "tenant", type = Long.class)
)
package kh.farrukh.aopltw.tenant;

import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

