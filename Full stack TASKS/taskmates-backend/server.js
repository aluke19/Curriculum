const express = require('express');
const mongoose = require('mongoose');
const cors = require('cors');
require('dotenv').config();

const authRoutes = require('./routes/authRoutes'); // <- este sí importa el router
const taskRoutes = require('./routes/taskRoutes');

const app = express();

app.use(cors());
app.use(express.json());
app.use('/api/tasks', taskRoutes);

app.use('/api/auth', authRoutes); // <- y este sí lo usa bien

mongoose.connect(process.env.MONGO_URI)
  .then(() => {
    app.listen(3000, () => console.log('Servidor corriendo en puerto 3000'));
  })
  .catch(err => console.error('Error de conexión:', err));
