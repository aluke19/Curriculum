const Task = require('../models/Task');

exports.createTask = async (req, res) => {
  try {
    const task = new Task({
      title: req.body.title,
      owner: req.user.id
    });
    await task.save();
    res.status(201).json(task);
  } catch (err) {
    res.status(500).json({ msg: 'Error al crear tarea' });
  }
};

exports.getTasks = async (req, res) => {
  try {
    const tasks = await Task.find({ owner: req.user.id });
    res.json(tasks);
  } catch (err) {
    res.status(500).json({ msg: 'Error al obtener tareas' });
  }
};

exports.deleteTask = async (req, res) => {
  try {
    const task = await Task.findOneAndDelete({ _id: req.params.id, owner: req.user.id });
    if (!task) return res.status(404).json({ msg: 'Tarea no encontrada' });
    res.json({ msg: 'Tarea eliminada' });
  } catch (err) {
    res.status(500).json({ msg: 'Error al eliminar tarea' });
  }
};
