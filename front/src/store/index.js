import { createStore } from "vuex"
import institutions from "./institutions"
import accounts from "./accounts"



export default createStore({
    state: {
        loading: false
    },
    getters: {
        isLoading: state => state.loading
    },

    modules: {
        institutions,
        accounts
    },

    plugins: [
        store => {
            store.subscribeAction({
                before: (_, state) => {
                    state.loading = true
                },
                after: (_, state) => {
                    state.loading = false
                }
            })
        }
    ]
})