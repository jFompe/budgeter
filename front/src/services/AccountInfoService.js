

const BASE_PATH = 'http://localhost:8080'
const REDIRECT_URI = 'http://localhost:3000/dashboard'
const DEFAULT_MAX_DAYS = 90



export async function getInstitutions(countryId='ES') {
    const institutions = await fetch(`${BASE_PATH}/api/v1/institutions?countryId=${countryId}`)
    return institutions.json()
}


export async function createAccountRequisition(institutionId, maxDays = DEFAULT_MAX_DAYS) {
    const body = {
        institutionId: institutionId,
        maxTransactionDays: Math.min(maxDays, DEFAULT_MAX_DAYS),
        redirectUri: REDIRECT_URI,
        lang: 'ES'
    }

    const response = await fetch(`${BASE_PATH}/api/v1/accounts`, {
        method: 'POST',
        body: JSON.stringify(body),
        headers: {
            "Content-Type": "application/json",
        }
    })    

    return response.json()
}


export async function getAccounts(requisitionId) {
    const accounts = await fetch(`${BASE_PATH}/api/v1/accounts/${requisitionId}`)
    return accounts.json().accounts
}


export async function getTransactions(accountId) {
    const transactions = await fetch(`${BASE_PATH}/api/v1/accounts/${accountId}/transactions`)
    return transactions.json()
}

