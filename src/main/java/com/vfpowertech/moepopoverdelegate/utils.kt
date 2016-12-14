package com.vfpowertech.moepopoverdelegate

import apple.foundation.NSArray

fun <T> nsarray(first: T, vararg items: T): NSArray<T> {
    @Suppress("UNCHECKED_CAST")
    return NSArray.arrayWithObjects(first, *items, null) as NSArray<T>
}

