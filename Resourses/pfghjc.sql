Select account, min(balance) 
from (
	Select (account), sum(value) over (partition by account order by date) as balance 
	from money_in_out
) as balance_by_dates
group by account