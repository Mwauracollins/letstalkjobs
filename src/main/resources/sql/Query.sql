-- Adding dummy data for Company entity
INSERT INTO company (name, description, location) 
VALUES ('Example Company', 'A sample company description', 'New York');


-- Adding dummy data for ContactInformation entity
INSERT INTO contact_information (email, email_visibility, phone_number, phone_number_visibility, website, website_visibility, company_id) 
VALUES ('john@example.com', true, '123456789', true, 'www.example.com', true, 1);

-- Adding dummy data for Position entity
INSERT INTO job_position (name, description) 
VALUES ('Software Engineer', 'Responsible for developing software applications');

-- Adding dummy data for JobCategory entity
INSERT INTO job_category (name, description) 
VALUES ('IT', 'Information Technology field');

-- Adding dummy data for JobOpportunity entity
INSERT INTO job_opportunity (name, date_posted, start_date, end_date, company_id, position_id, category_id, job_type, expected_pay) 
VALUES ('Software Developer Intern', '2024-03-28', '2024-04-01', '2024-09-30', 1, 1, 1, 'INTERNSHIP', 'Paid');

-- Adding dummy data for Internship entity
INSERT INTO internship (description, end_date, is_available, job_id) 
VALUES ('Summer internship program for software development', '2024-09-30', true, 1);

-- Adding dummy data for Attachment entity
INSERT INTO attachment (description, is_available, job_id) 
VALUES ('Project documentation', true, 1);
