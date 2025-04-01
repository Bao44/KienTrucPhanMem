const express = require('express');
const mysql = require('mysql2/promise');
const app = express();
const port = 3000;

// MySQL connection config
const dbConfig = {
  host: process.env.DB_HOST,
  user: process.env.DB_USER,
  password: process.env.DB_PASSWORD,
  database: process.env.DB_NAME,
  port: process.env.DB_PORT
};

app.get('/', async (req, res) => {
  try {
    const connection = await mysql.createConnection(dbConfig);
    res.send('Connected to MySQL successfully!');
    connection.end();
  } catch (error) {
    res.status(500).send('Error connecting to MySQL: ' + error.message);
  }
});

app.listen(port, () => {
  console.log(`App listening at http://localhost:${port}`);
});