SELECT a.car_id
FROM CAR_RENTAL_COMPANY_CAR AS a
JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY AS h
ON h.car_id = a.car_id
WHERE MONTH(h.START_DATE) = 10 AND a.car_type = '세단'
GROUP BY a.car_id
ORDER BY a.CAR_ID DESC
