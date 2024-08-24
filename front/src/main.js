/**
 * main.js
 *
 * Bootstraps Vuetify and other plugins then mounts the App`
 */

// Plugins
import { registerPlugins } from '@/plugins'

// Components
import App from './App.vue'

// Composables
import { createApp } from 'vue'
import { createStore } from 'vuex'
import { createRouter } from 'vue-router'

const store = createStore()
const router = createRouter()

const app = createApp(App)

registerPlugins(app)

app.use(store)
    .use(router)
    .mount('#app')