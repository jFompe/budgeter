import * as accountInfoService from '@/services/AccountInfoService'

export default {
    state: {
        institutions: [],
    },
    getters: {
        getInstitutions: state => state.institutions
    },
    actions: {
        async FETCH_INSTITUTIONS({ commit }) {
            const res = await accountInfoService.getInstitutions()
            commit('_setInstitutions', res)
        }
    },
    mutations: {
        _setInstitutions(state, payload) {
            state.institutions = payload
        }
    }
}