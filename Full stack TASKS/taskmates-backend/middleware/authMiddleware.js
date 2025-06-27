const jwt = require('jsonwebtoken');

const verifyToken = (req, res, next) => {
  const authHeader = req.header('Authorization');

  if (!authHeader || !authHeader.startsWith('Bearer ')) {
    return res.status(401).json({ msg: 'Acceso denegado. Token no proporcionado o mal formado.' });
  }

  const token = authHeader.split(' ')[1]; // aquí cogemos solo el token

  try {
    const verified = jwt.verify(token, process.env.JWT_SECRET);
    req.user = verified;
    next();
  } catch (err) {
    res.status(401).json({ msg: 'Token inválido' });
  }
};

module.exports = verifyToken;
