SELECT
	*
FROM
	v_on_record_icp_lj_organization_lj_basic a,
	(
		SELECT
			organizationName,
			min(beforeRevision) beforeRevision
		FROM
			v_on_record_icp_lj_organization_lj_basic
		GROUP BY
			organizationName
	) b
WHERE
	a.organizationName = b.organizationName
AND a.beforeRevision = b.beforeRevision 

-- and a.organizationName = '胜利油田';