import { createBrowserRouter, RouterProvider } from 'react-router-dom'
import Feed from './pages/Feed'
import LikedArtifacts from './pages/LikedArtifacts'
import Profile from './pages/Profile'
import './App.css'

const router = createBrowserRouter([
  {
    path: "/",
    element: <Feed />
  },
  {
    path: "/liked-artifacts",
    element: <LikedArtifacts />
  },
  {
    path: "/profile",
    element: <Profile />
  }
])

function App() {
  return (
    <RouterProvider router={router} />
  )
}

export default App
