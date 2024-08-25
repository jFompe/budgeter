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
import store from './store'
import router from './router'


const app = createApp(App)

registerPlugins(app)

app.use(store)
    .use(router)
    .mount('#app')