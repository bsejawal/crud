INSERT INTO users (`username`, `password`)
values
--  second parameter is password "pwd" encrypted with BCryptPasswordEncoder algorithm
('user','$2a$10$OL.rONYw3jqsDMD5qsQyWO5g2kL0cP.xpYjlkhWALfm3je.hL3icy'),
('admin','$2a$10$OL.rONYw3jqsDMD5qsQyWO5g2kL0cP.xpYjlkhWALfm3je.hL3icy'),
('bsejawal','$2a$10$OL.rONYw3jqsDMD5qsQyWO5g2kL0cP.xpYjlkhWALfm3je.hL3icy');

INSERT INTO role (`name`)
values
('ROLE_ADMIN'),
('ROLE_USER');



INSERT INTO user_role (`user_id`, `role_id`)
SELECT u.id, r.id
from users u, role r
where u.username = 'user'
and r.name = 'ROLE_USER';

INSERT INTO user_role (`user_id`, `role_id`)
SELECT u.id, r.id
from users u, role r
where u.username = 'admin'
and r.name = 'ROLE_ADMIN';

INSERT INTO user_role (`user_id`, `role_id`)
SELECT u.id, r.id
from users u, role r
where u.username = 'bsejawal'
and r.name = 'ROLE_ADMIN';

INSERT INTO user_role (`user_id`, `role_id`)
SELECT u.id, r.id
from users u, role r
where u.username = 'bsejawal'
and r.name = 'ROLE_USER';
