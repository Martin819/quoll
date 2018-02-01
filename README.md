# quoll
Simple dating service web application

Master: [![Build Status](https://travis-ci.org/Martin819/quoll.svg?branch=master)](https://travis-ci.org/Martin819/quoll)

Nightly: [![Build Status](https://travis-ci.org/Martin819/quoll.svg?branch=nightly)](https://travis-ci.org/Martin819/quoll)


How to deploy:
--------------

1. Create MySQL database called 'quoll' available on 'localhost:3306'
    ```sql
    CREATE DATABASE IF NOT EXISTS quoll DEFAULT CHARACTER SET utf8 DEFAULT COLLATE utf8_general_ci;
    ```

2. Build, compile and deploy the project with your IDE using maven _(First deploy may take up to 5 minutes to finish, due to running sql query with mock data)_



3. Make sure that `/src/main/java/resources/data.sql` file was executed during deploy. If not, do it now in the `quoll` MySQL database.

4. Remove or rename the `/src/main/java/resources/data.sql` file, so it's not executed during every deploy.

5. Once deployed, go to `http://localhost:8080/mock` to mock some additional attributes to predefined users. _(This may also take about a minute)_. When it's done, you'll be redirected to homepage.

6. Now, everything is set up. You can register your own account or use predefined one with some mocked conversations with `admin:heslo1234`.

7. Enjoy and feel free to contribute