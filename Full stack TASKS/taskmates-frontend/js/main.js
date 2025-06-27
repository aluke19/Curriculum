import { loginUser, getTasks, createTask, deleteTask } from './api.js';

const loginBtn = document.getElementById('loginBtn');
const addTaskBtn = document.getElementById('addTaskBtn');

loginBtn.addEventListener('click', async () => {
  const username = document.getElementById('username').value;
  const password = document.getElementById('password').value;

  const result = await loginUser(username, password);

  if (result.success) {
    alert('Login correcto');
    document.getElementById('auth').style.display = 'none';
    document.getElementById('task-section').style.display = 'block';
    mostrarTareas();
  } else {
    alert(result.msg);
  }
});

addTaskBtn.addEventListener('click', async () => {
  const title = document.getElementById('taskTitle').value;
  const ok = await createTask(title);

  if (ok) {
    document.getElementById('taskTitle').value = '';
    mostrarTareas();
  } else {
    alert('No se pudo crear la tarea');
  }
});

const mostrarTareas = async () => {
  const tareas = await getTasks();
  const lista = document.getElementById('listaTareas');
  lista.innerHTML = '';

  tareas.forEach(t => {
    const li = document.createElement('li');
    li.textContent = t.title + ' ';

    const btn = document.createElement('button');
    btn.textContent = '❌';
    btn.style.marginLeft = '10px';

    btn.addEventListener('click', async () => {
      const ok = await deleteTask(t._id);
      if (ok) mostrarTareas();
      else alert('No se pudo eliminar');
    });

    li.appendChild(btn);
    lista.appendChild(li);
  });
};

import { logout } from './api.js';

const logoutBtn = document.getElementById('logoutBtn');

logoutBtn.addEventListener('click', () => {
  logout(); // borra el token
  document.getElementById('task-section').style.display = 'none';
  document.getElementById('auth').style.display = 'block';
});
