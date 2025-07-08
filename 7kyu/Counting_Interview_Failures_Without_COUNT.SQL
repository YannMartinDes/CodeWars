select failure_reason, sum(1) as cnt
from interview_failures
group by failure_reason
order by cnt desc, failure_reason asc;
