# Spring Boot Application with Flyway Integration

This is a simple Spring Boot application that demonstrates the integration of **Flyway** database migration tool. The application includes a few entities, namely `Account`, `Authority`, and `Post`, along with their corresponding database tables.

## Entities

* The `Account` entity represents a user account in the system. It includes the following fields:
* The `Authority` entity represents a role or permission in the system. It includes the following fields:
* The `Post` entity represents a post made by an account. It includes the following fields:

## Database Migrations

The application utilizes Flyway for database migration management. The following migrations are included:

* `V1__create_posts_table.sql`: Creates the posts table.
* `V2__alter_posts_add_dates.sql`: Adds created_at and updated_at columns to the posts table.
* `V3__create_authorities_table.sql`: Creates the authorities table.
* `V4__create_accounts_table.sql`: Creates the accounts table.
* `V5__alter_posts_add_author_id.sql`: Adds the author_id column to the posts table and creates a foreign key constraint to the accounts table.
* `V6__create_accounts_authorities_table.sql`: Creates the accounts_authorities table to manage the many-to-many relationship between accounts and authorities.
* `V7__add_initial_data.sql`: Inserts initial data into the accounts table.
* `V8__remove_data.sql`: Deletes data from the accounts table.

## Getting Started

To run the application, follow these steps:

1. Clone the repository: git clone https://github.com/nazarchykur/sb-postgres-flyway
2. Build the application: `gradlew build`
3. Run the application: `gradlew bootRun`

The application will start, and the database migrations will be automatically executed during startup using Flyway.

## Database Setup using Docker Compose

* The application uses a PostgreSQL database for data storage. You can set up the required services using Docker Compose.
* The PostgreSQL service will be accessible on localhost:5432, and PgAdmin4 will be accessible on localhost:5050

## Testing our repositories using Testcontainers

The project includes unit tests and integration tests using `Testcontainers`. Testcontainers allows running tests with a real PostgreSQL container, providing a reliable and consistent testing environment. The tests can be found in the `src/test `directory.

To run the tests, execute the following command: `./gradlew test`

### Screenshots:

![img.png](src%2Fmain%2Fresources%2Fscreenshots%2Fimg.png)

![img_1.png](src%2Fmain%2Fresources%2Fscreenshots%2Fimg_1.png)

![img_2.png](src%2Fmain%2Fresources%2Fscreenshots%2Fimg_2.png)

![img_3.png](src%2Fmain%2Fresources%2Fscreenshots%2Fimg_3.png)

![img_4.png](src%2Fmain%2Fresources%2Fscreenshots%2Fimg_4.png)