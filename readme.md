Отчеты.
№1 select organization.name from organization where organization.id in
   (select org_id from contract left join payment on payment.contract_id=contract.id and payment.amount<>contract.amount)
№2
select name from organization where id in
(select org_id from contract join
(select contract_id, sum(amount) from payment group by contract_id) as c
on c.contract_id = contract.id)
Примечание: показывает клиентов в подрядке убывания прибыли, которую они принесли

Ограничения:
№1  ALTER TABLE payment ALTER COLUMN amount TYPE int CHECK ( amount < 500);

  Остальные пункты задания по отчетам и ограничениям не успел доделать. В файле samples.txt есть наброски.