CREATE CONSTRAINT ON (user:User) ASSERT user.username IS UNIQUE;
CREATE CONSTRAINT ON (role:Role) ASSERT role.name IS UNIQUE;