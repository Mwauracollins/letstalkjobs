-- Adding dummy data for Company entity
INSERT INTO company (name, description, location)
VALUES
    ('Example Company', 'A sample company description', 'Nairobi'),
    ('Tech Solutions Ltd', 'Leading tech company in Kenya', 'Nairobi'),
    ('Innovate IT Solutions', 'Providing innovative IT solutions', 'Mombasa'),
    ('CodeCrafters', 'Specializing in software development', 'Kisumu'),
    ('Data Dynamics', 'Experts in data analytics', 'Eldoret'),
    ('Swift Systems', 'Providing fast and reliable IT services', 'Nakuru'),
    ('Digital Trends', 'Staying ahead in the digital world', 'Nairobi'),
    ('Bright Future Technologies', 'Building a brighter future with technology', 'Mombasa'),
    ('Kenya Software Solutions', 'Solving problems through software', 'Kisumu'),
    ('TechGenius', 'Genius solutions for your tech needs', 'Eldoret'),
    ('Web Wizards', 'Masters of web development', 'Nakuru'),
    ('Data Driven Innovations', 'Driving innovation through data', 'Nairobi'),
    ('Coastal Computers', 'Bringing computing solutions to the coast', 'Mombasa'),
    ('Innovative Minds', 'Where innovation meets creativity', 'Kisumu'),
    ('TechBridge', 'Bridging the gap with technology', 'Eldoret'),
    ('Smart Solutions Ltd', 'Providing smart solutions for businesses', 'Nakuru'),
    ('Digital Dynamos', 'Dynamic solutions for the digital age', 'Nairobi'),
    ('Progressive Systems', 'Driving progress through technology', 'Mombasa'),
    ('Tech Titans', 'Titans of the tech industry', 'Kisumu'),
    ('Future Technologies', 'Building the future with technology', 'Eldoret');

-- Adding dummy data for ContactInformation entity
INSERT INTO contact_information (email, email_visibility, phone_number, phone_number_visibility, website, website_visibility, company_id)
VALUES
    ('john@example.com', true, '123456789', true, 'www.example.com', true, 1),
    ('info@techsolutions.com', true, '987654321', true, 'www.techsolutions.com', true, 2),
    ('contact@innovateit.com', true, '456123789', true, 'www.innovateit.com', true, 3),
    ('info@codecrafters.co.ke', true, '789456123', true, 'www.codecrafters.co.ke', true, 4),
    ('info@datadynamics.com', true, '321654987', true, 'www.datadynamics.com', true, 5),
    ('info@swiftsystems.co.ke', true, '654987321', true, 'www.swiftsystems.co.ke', true, 6),
    ('contact@digitaltrends.com', true, '987321654', true, 'www.digitaltrends.com', true, 7),
    ('info@brightfuturetech.com', true, '159357486', true, 'www.brightfuturetech.com', true, 8),
    ('info@kenyasoftwaresolutions.com', true, '369258147', true, 'www.kenyasoftwaresolutions.com', true, 9),
    ('info@techgenius.com', true, '258369147', true, 'www.techgenius.com', true, 10),
    ('info@webwizards.co.ke', true, '147258369', true, 'www.webwizards.co.ke', true, 11),
    ('info@datadriveninnovations.com', true, '369147258', true, 'www.datadriveninnovations.com', true, 12),
    ('info@coastalcomputers.co.ke', true, '258147369', true, 'www.coastalcomputers.co.ke', true, 13),
    ('info@innovativeminds.com', true, '147369258', true, 'www.innovativeminds.com', true, 14),
    ('info@techbridge.co.ke', true, '369258147', true, 'www.techbridge.co.ke', true, 15),
    ('info@smartsolutions.co.ke', true, '258369147', true, 'www.smartsolutions.co.ke', true, 16),
    ('info@digitaldynamos.com', true, '147258369', true, 'www.digitaldynamos.com', true, 17),
    ('info@progressivesystems.co.ke', true, '369147258', true, 'www.progressivesystems.co.ke', true, 18),
    ('info@techtitans.com', true, '258147369', true, 'www.techtitans.com', true, 19),
    ('info@futuretechnologies.co.ke', true, '147369258', true, 'www.futuretechnologies.co.ke', true, 20);

-- Adding dummy data for Position entity
INSERT INTO job_position (name, description)
VALUES
    ('Software Engineer', 'Responsible for developing software applications'),
    ('Web Developer', 'Creating and maintaining websites'),
    ('Data Analyst', 'Analyzing and interpreting data'),
    ('IT Support Specialist', 'Providing technical support for IT systems'),
    ('Network Administrator', 'Managing and maintaining computer networks'),
    ('UI/UX Designer', 'Designing user interfaces and experiences'),
    ('Database Administrator', 'Managing and organizing databases'),
    ('Cybersecurity Analyst', 'Protecting computer systems and networks from cyber threats'),
    ('Systems Analyst', 'Analyzing and improving computer systems'),
    ('Software Tester', 'Testing software for bugs and errors');

-- Adding dummy data for JobCategory entity
INSERT INTO job_category (name, description)
VALUES
    ('IT', 'Information Technology field'),
    ('Software Development', 'Creating software applications'),
    ('Web Development', 'Designing and building websites'),
    ('Data Analysis', 'Analyzing and interpreting data'),
    ('Cybersecurity', 'Protecting computer systems and networks'),
    ('Networking', 'Managing and maintaining computer networks'),
    ('UI/UX Design', 'Designing user interfaces and experiences'),
    ('Database Management', 'Organizing and managing databases'),
    ('Technical Support', 'Providing technical assistance for IT systems'),
    ('Quality Assurance', 'Ensuring the quality of software products');

-- Adding dummy data for JobOpportunity entity
INSERT INTO job_opportunity (name, date_posted, start_date, end_date, company_id, position_id, category_id, job_type, expected_pay)
VALUES
    ('Software Developer Intern', '2024-03-28', '2024-04-01', '2024-09-30', 1, 1, 1, 'INTERNSHIP', 'Paid'),
    ('Web Developer', '2024-03-28', '2024-04-01', '2024-09-30', 2, 2, 2, 'FULL_TIME', 'Competitive'),
    ('Data Analyst', '2024-03-28', '2024-04-01', '2024-09-30',3, 3, 3, 'ATTACHMENT', 'Negotiable'),
    ('IT Support Specialist', '2024-03-28', '2024-04-01', '2024-09-30', 4, 4, 4, 'INTERNSHIP', 'Hourly rate'),
    ('Network Administrator', '2024-03-28', '2024-04-01', '2024-09-30', 5, 5, 5, 'FULL_TIME', 'Competitive'),
    ('UI/UX Designer', '2024-03-28', '2024-04-01', '2024-09-30', 6, 6, 6, 'FULL_TIME', 'Competitive'),
    ('Database Administrator', '2024-03-28', '2024-04-01', '2024-09-30', 7, 7, 7, 'FULL_TIME', 'Competitive'),
    ('Cybersecurity Analyst', '2024-03-28', '2024-04-01', '2024-09-30', 8, 8, 8, 'FULL_TIME', 'Competitive'),
    ('Systems Analyst', '2024-03-28', '2024-04-01', '2024-09-30', 9, 9, 9, 'ATTACHMENT', 'Competitive'),
    ('Software Tester', '2024-03-28', '2024-04-01', '2024-09-30', 10, 10, 10, 'ATTACHMENT', 'Competitive'),
    ('Software Engineer', '2024-03-28', '2024-04-01', '2024-09-30', 11, 11, 11, 'FULL_TIME', 'Competitive'),
    ('Web Developer', '2024-03-28', '2024-04-01', '2024-09-30', 12, 12, 12, 'ATTACHMENT', 'Competitive'),
    ('Data Analyst', '2024-03-28', '2024-04-01', '2024-09-30', 13, 13, 13, 'FULL_TIME', 'Competitive'),
    ('IT Support Specialist', '2024-03-28', '2024-04-01', '2024-09-30', 14, 14, 14, 'INTERNSHIP', 'Competitive'),
    ('Network Administrator', '2024-03-28', '2024-04-01', '2024-09-30', 15, 15, 15, 'FULL_TIME', 'Competitive'),
    ('UI/UX Designer', '2024-03-28', '2024-04-01', '2024-09-30', 16, 16, 16, 'FULL_TIME', 'Competitive'),
    ('Database Administrator', '2024-03-28', '2024-04-01', '2024-09-30', 17, 17, 17, 'INTERNSHIP', 'Competitive'),
    ('Cybersecurity Analyst', '2024-03-28', '2024-04-01', '2024-09-30', 18, 18, 18, 'FULL_TIME', 'Competitive'),
    ('Systems Analyst', '2024-03-28', '2024-04-01', '2024-09-30', 19, 19, 19, 'INTERNSHIP', 'Competitive'),
    ('Software Tester', '2024-03-28', '2024-04-01', '2024-09-30', 20, 20, 20, 'FULL_TIME', 'Competitive');
