let token = '';

export const loginUser = async (username, password) => {
  const res = await fetch('http://localhost:3000/api/auth/login', {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({ username, password })
  });

  const data = await res.json();

  if (res.ok) {
    token = data.token;
    return { success: true, token };
  } else {
    return { success: false, msg: data.msg || 'Login fallido' };
  }
};

export const getTasks = async () => {
  const res = await fetch('http://localhost:3000/api/tasks', {
    headers: {
      'Authorization': 'Bearer ' + token
    }
  });
  return await res.json();
};

export const createTask = async (title) => {
  const res = await fetch('http://localhost:3000/api/tasks', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + token
    },
    body: JSON.stringify({ title })
  });

  return res.ok;
};

export const deleteTask = async (id) => {
  const res = await fetch(`http://localhost:3000/api/tasks/${id}`, {
    method: 'DELETE',
    headers: {
      'Authorization': 'Bearer ' + token
    }
  });

  return res.ok;
};

export const logout = () => {
  token = '';
};
