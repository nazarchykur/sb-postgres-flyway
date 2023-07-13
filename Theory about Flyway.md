## Using Flyway 

Here is a great article about Flyway (almost everything in one place)
https://docs.google.com/document/d/1QNdfySWhYFwF2vZXjIjRLkzGLgxO2WsRrA9dpC7FadM/edit



When using Flyway, you typically create a separate migration script for each schema change or entity you want to introduce into your database. Each migration script should have a unique version number, and Flyway will apply them in the order of their version numbers.

For example, let's say you have an existing table named user in your database. If you want to introduce a new entity called product with its own table, you would create a new migration script for it. The version number of this script should be higher than the version of the previous migration scripts.

Here's an example of how your migration scripts could be organized:

### **db/migration**

    ├── V1__Create_user_table.sql
    ├── V2__Create_product_table.sql

In the above example, `V1__Create_user_table.sql` creates the user table, and `V2__Create_product_table.sql` creates the product table. By following this approach, Flyway will ensure that the scripts are applied in the correct order, maintaining the integrity of your database schema.

Whenever you introduce a new entity or modify the schema, you would create a new migration script with an incremented version number and write the necessary SQL statements to apply the changes.

By keeping your migration scripts organized and incrementing the version numbers, Flyway can effectively manage and apply the changes to your database schema as your application evolves over time.


## update existing tables

When you need to update existing tables, add new columns, or remove columns in Flyway, you can follow these steps:

1. Create a new migration script:

   * Decide on a meaningful name for your script, such as V3__Update_table.sql. The version number 3 should be higher than the version of your previous scripts.
   * Place the new migration script in the appropriate location, such as db/migration.
   
2. Write the necessary SQL statements in the migration script:

   * Use the ALTER TABLE statement to modify existing tables, add new columns, or remove columns.
   
   * Here are a few examples of SQL statements you might use:

    -- Modify an existing column
    
        `ALTER TABLE your_table ALTER COLUMN column_name TYPE new_data_type;`
    
    -- Add a new column
    
        `ALTER TABLE your_table ADD COLUMN new_column_name data_type;`
    
    -- Remove a column
    
       `ALTER TABLE your_table DROP COLUMN column_name;`

   

  * Customize the SQL statements based on the specific changes you need to make to your tables.


3. Build and run your application:

   * Flyway will automatically detect the new migration script and apply it when your application starts.
   * The script will be executed in order based on the version number, ensuring that the changes are applied correctly.

By following this approach, you can easily update existing tables, add new columns, or remove columns using Flyway. Each migration script represents a specific set of changes, and Flyway will apply them in order to keep your database schema up to date as your application evolves.

## Although it is normal to have a large number of migration scripts

it is perfectly fine to have multiple migration scripts in your application. In fact, having a separate migration script for each set of changes is a recommended practice when using Flyway.

As your application evolves and new features are added, it is common to accumulate a significant number of migration scripts over time. Each migration script represents a specific set of changes to your database schema.

Having multiple scripts allows Flyway to manage and apply the changes in a controlled manner. When your application starts, Flyway will automatically detect the new scripts and apply them in the correct order based on their version numbers. This ensures that the database schema is updated consistently and accurately.

Although it is normal to have a large number of migration scripts, it is still important to keep them organized.


## The db/migration folder

The `db/migration` folder is typically used to store all your Flyway migration scripts. You can organize your migration scripts within this folder using subdirectories if needed, but it's not necessary.

For example, your db/migration folder structure might look like this:
![img_5.png](src%2Fmain%2Fresources%2Fscreenshots%2Fimg_5.png)

All your migration scripts are placed directly inside the db/migration folder. Flyway will scan this folder and automatically apply the scripts in the order defined by their version numbers.


## an initialization script

Creating an initialization script to set up tables with data is a common practice, especially when you want to have some initial data for testing or when starting a new application. This script is often referred to as a "bootstrap" or "seed" script.

The initialization script allows you to pre-populate your tables with sample data or default values, ensuring that your application has the necessary data for testing or initial usage.

Typically, the initialization script is executed along with other migration scripts during the application startup. Flyway ensures that the initialization script is executed in the correct order based on its version number, just like any other migration script.

Here's an example of how your initialization script could be organized:
![img_6.png](src%2Fmain%2Fresources%2Fscreenshots%2Fimg_6.png)

In the above example, the V100__Initialize_data.sql script contains the necessary SQL statements to populate your tables with initial data.

### However, it's important to note that the initialization script is typically used only during the initial setup or for testing purposes. In a production environment, it's more common to use data migration scripts that handle data changes along with the schema changes.

By separating the initialization script from other migration scripts, you can keep your data setup separate and easily switch between different data setups when needed (e.g., switching between development and testing data).

So, while it is possible to have an initialization script for setting up tables with data, its usage may be limited to specific scenarios, such as initial setup or testing.

## Data migration scripts

Data migration scripts are used to manage changes to data in your database along with schema changes. These scripts allow you to modify or transform existing data during the migration process.

Data migration scripts are typically used in scenarios where you need to perform data-related tasks that go beyond simply creating or altering tables. Some examples of data migration tasks include:

1. `Data Transformation`: Modifying existing data to conform to new requirements or data models. For example, if you add a new column to a table and need to populate it with derived or calculated values based on existing data.
2. `Data Cleanup`: Performing data cleanup tasks, such as removing duplicates, fixing data inconsistencies, or updating data formats.

3. `Data Import`: Importing data from external sources or other systems into your database. This could involve parsing files, transforming data formats, and loading it into the appropriate tables.

4. `Data Backfilling`: Adding or updating data in existing tables based on new business rules or requirements. This is often necessary when introducing new features or changing application logic.