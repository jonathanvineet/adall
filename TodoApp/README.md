# To-Do App

A simple React application for managing daily tasks and to-do items.

## Features
- Add new tasks
- Delete tasks
- Clean and minimal UI
- Task persistence during session

## Tech Stack
- **Framework**: React
- **Language**: JavaScript

## Prerequisites
- Node.js installed
- npm (comes with Node)

## Setup Instructions

1. Check if Node.js and npm are installed:
```bash
node -v
npm -v
```

2. Create a React app:
```bash
npx create-react-app todo-app
cd todo-app
```

3. Replace the content of `src/App.js` with the code from `App.js`

4. Start the app:
```bash
npm start
```

The app will open in your browser at `http://localhost:3000`

## How to Use
1. Type a task in the input field
2. Click the "Add" button to add it to the list
3. Click the ❌ button to delete a task
4. Continue adding and managing your tasks

## Result
The application allows users to add and delete daily tasks successfully.

## Future Enhancements
- Mark tasks as completed (✔)
- Local storage to persist tasks between sessions
- Better UI styling (buttons, cards, animations)
- Task categories
- Due date tracking
- Dark mode support
- Filter completed/pending tasks
