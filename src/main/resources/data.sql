INSERT INTO users (`username`, `password`)
values
('user','pwd'),
('admin','pwd');

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