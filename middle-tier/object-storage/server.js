import express from 'express'
import cors from 'cors'
import {generateUploadURL} from './s3.js'

const app = express()
app.use(cors())

const port = 3000

app.get('/s3', async (req, res) => {
  const url = await generateUploadURL()
  res.send({url})
})

app.listen(port, () => {
  console.log(`Objects-storage server listening on port ${port}`)
})