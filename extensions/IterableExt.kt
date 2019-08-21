package com.bignerdranch.nyethack.extensions

private fun <T> Iterable<T>.random():T=this.shuffled().first()
