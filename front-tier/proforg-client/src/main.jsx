import React from 'react';
import { createBrowserRouter, RouterProvider } from 'react-router-dom';
import ReactDOM from 'react-dom/client';
import App from './App';
import MyArtifacts from './pages/MyArtifacts';
import './index.css';
import ResponsiveAppBar from './components/ResponsiveAppBar';

const router = createBrowserRouter([
  {
    path: "/",
    element: <App />,
  },
  {
    path: "/my-artifacts",
    element: <MyArtifacts />,
  },
]);

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <ResponsiveAppBar />
    <RouterProvider router={router} />
  </React.StrictMode>,
);
