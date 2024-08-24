

const BASE_PATH = 'http://localhost:8080'
const REDIRECT_URI = 'http://localhost:3000/dashboard'



async function getInstitutions(countryId='ES') {
    const institutions = await fetch(`${BASE_PATH}/api/v1/institutions?contryId=${countryId}`)
    return institutions.json()
}


async function createAccountRequisition(institutionId, maxDays) {
    const body = {
        institutionId: institutionId,
        maxTransactionDays: maxDays,
        redirectUri: REDIRECT_URI,
        lang: 'ES'
    }

    const response = await fetch(`${BASE_PATH}/api/v1/accounts`, {
        method: 'POST',
        body: JSON.stringify(body)

    })

    return response.json().id
}


async function getAccounts(requisitionId) {
    const accounts = await fetch(`${BASE_PATH}/api/v1/accounts/${requisitionId}`)
    return accounts.json().accounts
}


async function getTransactions(accountId) {
    const transactions = await fetch(`${BASE_PATH}/api/v1/accounts/${accountId}/transactions`)
    return transactions.json()
}