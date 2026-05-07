SELECT name, salary
FROM Employees
WHERE salary > (SELECT AVG(salary) FROM Employees);

SELECT name
FROM Employees
WHERE dept_id IN (SELECT dept_id FROM Departments WHERE dept_name IN ('IT', 'Finance'));

SELECT name, salary, dept_id
FROM Employees e
WHERE salary > (
    SELECT AVG(salary)
    FROM Employees
    WHERE dept_id = e.dept_id
);

SELECT name
FROM Employees
WHERE emp_id IN (
    SELECT emp_id
    FROM Projects
    WHERE emp_id IN (
        SELECT emp_id
        FROM Employees
        WHERE dept_id = (SELECT dept_id FROM Departments WHERE dept_name = 'IT')
    )
);
