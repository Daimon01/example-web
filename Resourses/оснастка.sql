from
	(select 
		department, 
		(	select date
			from rig_operations 
			where rig_operations.action = 'take'
		) as date_take, 
		(	select date 
			from rig_operations 
			where rig_operations.action = 'free'
		) as date_free
	from rig_operations
	group by department)